package com.person.vincent.conditional

/**
 * Author: vincent
 * Date: 2018-01-22 11:26:00
 * Comment: 在 Mac OS 下所需要创建的 bean
 */

class MacOSListService : ListService {

    override fun showListCmd() = "ls"
}