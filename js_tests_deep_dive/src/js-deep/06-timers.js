/**
 * Return a stop watch object with the following API:
 * getTime - return number of seconds elapsed
 * start - start counting time
 * stop - stop counting time
 * reset - sets seconds elapsed to zero
 */
exports.createStopWatch = function() {
    let startTime = null;
    let elapsedTime = 0;
  
    const start = function() {
      if (startTime === null) {
        startTime = new Date();
      }
    };
  
    const stop = function() {
      if (startTime !== null) {
        const endTime = new Date();
        elapsedTime += (endTime - startTime) / 1000; // Convert milliseconds to seconds
        startTime = null;
      }
    };
  
    const reset = function() {
      startTime = new Date(); // Update startTime to the current time
      elapsedTime = 0;
    };
  
    const getTime = function() {
      if (startTime !== null) {
        const currentTime = new Date();
        return elapsedTime + (currentTime - startTime) / 1000;
      }
      return elapsedTime;
    };
  
    return {
      start,
      stop,
      reset,
      getTime
    };
  };
  