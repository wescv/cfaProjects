/**
 * Determine the location of an item in the array
 */
exports.indexOf = function (arr, item) {

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === item) {
            return i;
        }
    }
    return -1;
};

/**
 * Sum the items of an array
 */
exports.sum = function (arr) {

    if (Array.length === 0) {
        return 0;
    }
    return arr.reduce((a, b) => a + b);

};

/**
 * Remove all instances of an item from an array
 */
exports.remove = function (arr, item) {

    return arr.filter(a => a !== item);

};

/**
 * Remove all instances of an item from an array by mutating original array
 */
exports.removeWithoutCopy = function (arr, item) {

    let i = 0;
    while (i < arr.length) {
        if (arr[i] === item) {
            arr.remove(i);
        } else {
            i++;
        }
    }

    return arr.length;

};
/**
 * Add an item to the end of the array
 */
exports.append = function (arr, item) {

};

/**
 * Remove the last item of an array
 */
exports.truncate = function (arr) {

    arr.pop();


};

/**
 * Add an item to the beginning of an array
 */
exports.prepend = function (arr, item) {
};

/**
 * Remove the first item of an array
 */
exports.curtail = function (arr) {
};

/**
 * Join two arrays together
 */
exports.concat = function (arr1, arr2) {
};

/**
 * Add an item to an array in the specified position
 */
exports.insert = function (arr, item, index) {
};

/**
 * Count the number of occurrences of an item in an array
 */
exports.count = function (arr, item) {
};

/**
 * Find all items which container multiple occurrences in the array
 */
exports.duplicates = function (arr) {
};

/**
 * Square each number in the array
 */
exports.square = function (arr) {
};

/**
 * Find all occurrences of an item in an array
 */
exports.findAllOccurrences = function (arr, target) {
};
