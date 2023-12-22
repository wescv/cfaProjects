/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function (counter) {
    counter = counter || 0;
  
    const counterModule = {
      get: function () {
        return counter;
      },
      increment: function () {
        counter++;
        return counter;
      },
      reset: function () {
        counter = 0;
        return counter;
      }
    };
  
    return counterModule;
  };

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function(initialName) {
    if (typeof initialName !== 'string' || initialName === '') {
        throw new Error('Name must be a non-empty string');
    }
    var name = initialName;
    var age = 0;
    return {
        getName: function() {
            return name;
        },
        getAge: function() {
            return age;
        },
        setName: function(newName) {
            name = newName;
        },
        setAge: function(newAge) {
            age = newAge;
        },
    };
};
