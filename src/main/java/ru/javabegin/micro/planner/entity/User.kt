package ru.javabegin.micro.planner.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.*

/*

пользователь - основной объект, с которым связаны все остальные (через внешние ключи)

*/



@Entity
@Table(name = "user_data", schema = "users", catalog = "planner_users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var email: String? = null

    var username: String? = null

    @Column(name = "userpassword")
    var password: String? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "users")
    var roles: Set<Role>? = null


    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val user = o as User
        return id == user.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    override fun toString(): String {
        return username!!
    }
}
