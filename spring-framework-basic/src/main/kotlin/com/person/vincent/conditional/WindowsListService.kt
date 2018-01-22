package com.person.vincent.conditional

/**
 * Author: vincent
 * Date: 2018-01-22 11:24:00
 * Comment: 在 Windows 下所需要创建的 bean
 */

class WindowsListService: ListService {

    override fun showListCmd() = "dir"
}