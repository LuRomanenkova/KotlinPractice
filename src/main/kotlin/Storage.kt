class Storage {
    var map = mutableMapOf<String, Int>()

    fun contains(name: String) : Boolean {
        return map.contains(name)
    }

    fun add(name: String, age: String): Boolean {
        if (contains(name)) {
            return false
        }
        if (Validator.validateName(name) && Validator.validateAge(age)) {
            map.put(name, age.toInt())
            return true
        }
        return false
    }

    fun get(name: String): Int? {
        if (contains((name))) {
            return map.get(name)
        }
        return null
    }

    fun delete(name: String): Boolean {
        if (contains(name)) {
            map.remove(name);
            return true
        }
        return false
    }

    fun edit(name: String, newName: String, age: String) : Boolean {
        if (contains(name)) {
            if (Validator.validateName(newName) && Validator.validateAge(age)) {
                map.remove(name)
                map.put(newName, age.toInt())
                return true
            }
        }
        return false
    }
}