package com.person.vincent.domain

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.GenericGenerators
import org.hibernate.annotations.UpdateTimestamp

import javax.persistence.*
import java.sql.Timestamp
import java.util.*

/**
 * Author: vincent
 * Date: 2018-03-24 08:59:00
 * Comment:
 */

@Entity
// 可选注解，当表名与类名相同时可省略
@Table(name = "account")
// 命名查询，在实体类中定义命名查询，类似于 rails 中的 scope，查询名称即 'findByName' 必须全局唯一。
// 另外，JPA 使用的是 Hibernate 的查询语言 HQL，注意语法规范
@NamedQuery(name = "findByName", query = "select t from Account t where t.name = :name")
data class Account(

        // 主键并设置主键生成策略
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        // 可选注解，当属性名与字段名相同时可省略，nullable = false 不可为空
        @Column(name = "name", nullable = false)
        var name: String = "",

        // unique = true 唯一标识
        @Column(unique = true)
        var openId: String = UUID.randomUUID().toString(),

        // @CreationTimestamp 保存对象到数据库时自动注入时间戳
        // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 对象转JSON时，自动格式化时间戳
        // updatable = false 更新对象时不更新时间戳
        @CreationTimestamp
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @Column(name = "created_at", updatable = false)
        var createdAt: Timestamp = Timestamp(System.currentTimeMillis()),

        @UpdateTimestamp
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var updatedAt: Timestamp = Timestamp(System.currentTimeMillis())
) {
    /**
     * Hibernate 尝试通过反射来创建一个 bean，它通过调用无参构造函数来创建对象，它使用 setter 方法来设置属性
     * 如果没有无参构造函数，将会发生异常
     * org.hibernate.InstantiationException: No default constructor for entity...
     */
    constructor() : this(-1)
    constructor(name: String) : this(-1, name)
}
