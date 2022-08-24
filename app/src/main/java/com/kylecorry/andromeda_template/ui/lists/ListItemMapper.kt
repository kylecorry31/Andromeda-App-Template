package com.kylecorry.andromeda_template.ui.lists

interface ListItemMapper<T> {
    fun map(value: T): ListItem
}