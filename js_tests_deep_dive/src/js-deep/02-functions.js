/**
 * Return result of calling function with arguments as present in array
 */
exports.argsAsArray = function(fn, arr) {
    // Check if fn is a function
    if (typeof fn !== 'function') {
      throw new Error('The first parameter must be a function');
    }
  
    // Check if arr is an array
    if (!Array.isArray(arr)) {
      throw new Error('The second parameter must be an array');
    }
  
    // Call the function with the arguments from the array and return the result
    return fn(...arr);
  };
  
/**
 * Return the result of calling a function with the provided obj as context
 * for the implicit argument this
 */
exports.speak = function(fn, obj) {

    // Check if fn is a function
  if (typeof fn !== 'function') {
    throw new Error('The first parameter must be a function');
  }

  // Call the function with obj as the context (this) and return the result
  return fn.call(obj);
};

/**
 * Return a prefixer function that concatenates a string argument with a prefix
 */
exports.stringPrefixer = function(prefix) {

    // Return the prefixer function
  return function(str) {
    // Concatenate the prefix and the string argument
    return `${prefix}${str}`;
  };
};


/**
 * Create an array of functions, each producing a result obtained
 * from applying the transform function to an argument from values array
 */
exports.makeResultFunctions = function(values, transform) {
   
    // Create an array of functions
    const resultFunctions = values.map(value => {
      return function () {
        return transform(value);
      };
    });
  
    return resultFunctions;
};

/**
 * From a function which receives three arguments,
 * of which only two are available, create a new function
 * which wraps the original one with the missing argument
 */
exports.createWrapperFunction = function(fn, arg1, arg2) {
    
    // Return a new function that wraps the original function
    return function(missingArg) {
      // Call the original function with all three arguments
      return fn(arg1, arg2, missingArg);
    };
  };
  

/**
 * Return the sum of all arguments
 */
exports.sumArguments = function() {
    // Convert the arguments object to an array and use reduce to calculate the sum
    const argsArray = Array.from(arguments);
    const sum = argsArray.reduce((acc, current) => acc + current, 0);
    return sum;
  };
  

/**
 * Execute the function, passing it all the provided arguments
 */
exports.callIt = function(fn) {
};

/**
 * From a function which receives a variable number of arguments,
 * return a wrapper function which adds additional argumens to the ones
 * available and calls the original function
 */
exports.createAddArgumentsFunction = function(fn) {
};
