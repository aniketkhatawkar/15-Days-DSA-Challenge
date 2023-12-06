function throttle(func, interval) {
    let lastCallTime = 0;
    let timeout;
  
    return function (...args) {
      const now = Date.now();
      const elapsedTime = now - lastCallTime;
  
      if (elapsedTime >= interval) {
        lastCallTime = now;
        func.apply(this, args);
      } else {
        clearTimeout(timeout);
        timeout = setTimeout(() => {
          lastCallTime = Date.now();
          func.apply(this, args);
        }, interval - elapsedTime);
      }
    };
  }
  
  // Example usage:
  
  // Function to be throttled
  function someFunction() {
    console.log("Function called!");
  }
  
  // Throttle the function to be called at most once every 500 milliseconds
  const throttledFunction = throttle(someFunction, 500);
  
  // Calling the throttled function multiple times quickly
  throttledFunction(); // This will execute immediately
  throttledFunction(); // This will be delayed and execute after the throttle interval
  throttledFunction(); // This will be ignored within the throttle interval
  