class Validator {
    companion object {
        fun validateName(wname: String?): Boolean {
            var name: String
            if (!wname.isNullOrBlank()) {
                name = wname;
                if (name[0] in 'А'..'Я') {
                    var i: Int
                    for (i in 1 until name.length){
                        if (name[i] !in 'а'..'я') {
                            return false
                        }
                    }
                    return true
                }
                else {
                    return false
                }
            }
            else {
                return false
            }
        }

        fun validateAge(wage: String?): Boolean {
            if (!wage.isNullOrBlank()) {
                val age = wage;
                for (c in age) {
                    if (c !in '0'..'9') {
                        return false
                    }
                }
                return true
            }
            else {
                return false
            }

        }
    }
}