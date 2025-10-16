package com.jinsub.practice

import javax.inject.Qualifier

@Qualifier
annotation class UserQualifier(val age:Int, val height:Int) {
}