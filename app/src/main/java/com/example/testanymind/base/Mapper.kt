package com.example.testanymind.base

interface Mapper<E, D> {
    fun map(input: E): D
}
interface MapperWithParam<E, F, D> {
    fun map(input: E, data: F): D
}
