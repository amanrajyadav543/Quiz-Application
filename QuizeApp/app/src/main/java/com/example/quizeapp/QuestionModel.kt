package com.example.quizeapp

class QuestionModel
    {
        var Question : String?=null
        var Option1: String?=null
        var Option2: String?=null
        var Option3: String?=null
        var Option4: String?=null

        val ans: String?=null

        constructor()
        constructor(
            Question: String?,
            Option1: String?,
            Option2: String?,
            Option3: String?,
            Option4: String?
        ) {
            this.Question = Question
            this.Option1 = Option1
            this.Option2 = Option2
            this.Option3 = Option3
            this.Option4 = Option4
        }

    }