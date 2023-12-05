package com.mobdeve.mp

class StudentDataHelper {
    companion object{
        fun studentData(companyNames: List<StudentPostModel>): ArrayList<StudentPostModel> {
            val data = ArrayList<StudentPostModel>()
            companyNames.forEach { i ->
                data.add(
                    StudentPostModel(
                        i.requirements.toString(),
                        i.phonenumber.toString(),
                        i.email.toString(),
                        i.companyname.toString(),
                        i.address.toString()

                    )
                )
            }

            return data
        }
    }

}
