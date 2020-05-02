import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Tests {

    @Test fun ChackingNameValidation() {
        Assertions.assertEquals(false, Validator.validateName(""))
        Assertions.assertEquals(false, Validator.validateName(" "))
        Assertions.assertEquals(false, Validator.validateName("" +
                ""))
        Assertions.assertEquals(false, Validator.validateName(" "))
        Assertions.assertEquals(false, Validator.validateName("ЛЮСЯ"))
        Assertions.assertEquals(true, Validator.validateName("Люся"))
        Assertions.assertEquals(false, Validator.validateName("ЛЮСЯ"))
        Assertions.assertEquals(false, Validator.validateName("люся"))
    }

    @Test fun ChackingAgeValidation() {
        Assertions.assertEquals(false, Validator.validateAge(""))
        Assertions.assertEquals(false, Validator.validateAge(" "))
        Assertions.assertEquals(false, Validator.validateAge("" +
                ""))
        Assertions.assertEquals(false, Validator.validateAge("  "))
        Assertions.assertEquals(true, Validator.validateAge("0"))
        Assertions.assertEquals(true, Validator.validateAge("19"))
        Assertions.assertEquals(false, Validator.validateAge("19.01"))
        Assertions.assertEquals(false, Validator.validateAge("-19"))
    }



    @Test fun ChackingAdd() {
        var storage = Storage()

        Assertions.assertEquals(true, storage.add("Люда", "5"))
        Assertions.assertEquals(false, storage.add("люда", "5"))
        Assertions.assertEquals(false, storage.add("Люда", "-5"))
        Assertions.assertEquals(false, storage.add("", "5"))
        Assertions.assertEquals(false, storage.add("    ", "5"))
        Assertions.assertEquals(false, storage.add(" ", "-5"))
        Assertions.assertEquals(true, storage.add("Влад", "20"))
    }

    @Test fun ChackingContains() {
        var storage = Storage()
        var a = storage.add("Люда", "5")
        var b = storage.add("Влад", "20")
        Assertions.assertEquals(false, storage.contains("Маша"))
        Assertions.assertEquals(true, storage.contains("Люда"))
        Assertions.assertEquals(true, storage.contains("Влад"))

    }

    @Test fun ChackingEdit() {
        var storage = Storage()
        var a = storage.add("Люда", "5")
        var b = storage.add("Влад", "20")
        Assertions.assertEquals(false, storage.edit("Маша", "Люда", "11"))
        Assertions.assertEquals(false, storage.edit("Люда", "люда", "11"))
        Assertions.assertEquals(false, storage.edit("Люда", "Люда", "-11"))
        Assertions.assertEquals(true, storage.edit("Люда", "Люда", "19"))
    }

    @Test fun ChackingGet() {
        var storage = Storage()
        var a = storage.add("Люда", "5")
        var b = storage.add("Влад", "20")
        Assertions.assertEquals(null, storage.get("Маша"))
        Assertions.assertEquals(5, storage.get("Люда"))
        Assertions.assertEquals(20, storage.get("Влад"))
    }

    @Test fun ChackingDelete() {
        var storage = Storage()
        var a = storage.add("Люда", "5")
        var b = storage.add("Влад", "20")
        Assertions.assertEquals(false, storage.delete("Маша"))
        Assertions.assertEquals(true, storage.delete("Люда"))
        Assertions.assertEquals(true, storage.delete("Влад"))
        Assertions.assertEquals(false, storage.delete("Люда"))
        Assertions.assertEquals(false, storage.delete("Влад"))
    }
}