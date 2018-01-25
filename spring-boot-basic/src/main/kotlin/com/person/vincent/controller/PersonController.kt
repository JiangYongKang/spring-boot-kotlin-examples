package com.person.vincent.controller

import com.person.vincent.model.Person
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Author: vincent
 * Date: 2018-01-25 16:29:00
 * Comment:
 */

@Controller
@RequestMapping("/person")
class PersonController {

    @RequestMapping("/")
    fun index(model: Model): String {
        val person = Person("aa", 11)
        val people = arrayListOf(
                Person("xx", 11),
                Person("yy", 22),
                Person("zz", 33)
        )
        model.addAttribute("singlePerson", person)
        model.addAttribute("people", people)
        return "people/index"
    }
}