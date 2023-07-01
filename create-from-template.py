import os
import stat
import shutil
import datetime
import re

app_name = input("App Name: ")
package_name = input("Package Name: ")
default_dir_name = app_name.replace(' ', '-').replace('.', '-')
dir_name = input("Directory Name [" + default_dir_name + "]: ")

if dir_name == "":
    dir_name = default_dir_name

if os.path.exists(dir_name):
    should_overwrite = input("Directory already exists. Overwrite? [y/N]: ")
    if should_overwrite.lower() != "y":
        exit()

def clone(repo_url, dir_name):
    os.system(f"git clone {repo_url} {dir_name}")

def on_rm_error(func, path, exc_info):
    #from: https://stackoverflow.com/questions/4829043/how-to-remove-read-only-attrib-directory-with-python-in-windows
    os.chmod(path, stat.S_IWRITE)
    os.unlink(path)

def delete_dir(dir_name):
    # Delete the directory and all its contents using os.rmdir
    shutil.rmtree(dir_name, onerror=on_rm_error)

# Clone the template
clone("https://github.com/kylecorry31/Andromeda-App-Template", dir_name)

# Delete the .git folder
delete_dir(f"{dir_name}/.git")

# Replace the package name
valid_extensions = [".xml", ".java", ".gradle", ".kt", ".kts"]
for root, dirs, files in os.walk(dir_name):
    for name in files:
        if any(name.endswith(ext) for ext in valid_extensions):
            path = os.path.join(root, name)
            with open(path, "r") as f:
                contents = f.read()
            contents = contents.replace("com.kylecorry.andromeda_template", package_name)
            with open(path, "w") as f:
                f.write(contents)

# Rename the package folder
os.rename(f"{dir_name}/app/src/main/java/com/kylecorry/andromeda_template", f"{dir_name}/app/src/main/java/{package_name.replace('.', '/')}")

# Rename the app_name in strings.xml
with open(f"{dir_name}/app/src/main/res/values/strings.xml", "r") as f:
    contents = f.read()
    contents = contents.replace("Andromeda Template App", app_name)
    with open(f"{dir_name}/app/src/main/res/values/strings.xml", "w") as f:
        f.write(contents)

# Rename the app name in settings.gradle
with open(f"{dir_name}/settings.gradle.kts", "r") as f:
    contents = f.read()
    contents = contents.replace("Andromeda App Template", app_name)
    with open(f"{dir_name}/settings.gradle.kts", "w") as f:
        f.write(contents)

# Clear out the readme
with open(f"{dir_name}/README.md", "w") as f:
    f.write(f"# {app_name}")

# Update the date in the license
with open(f"{dir_name}/LICENSE", "r") as f:
    contents = f.read()
    # Use regex to replace the date
    contents = re.sub(r"202\d", str(datetime.datetime.now().year), contents)
    with open(f"{dir_name}/LICENSE", "w") as f:
        f.write(contents)