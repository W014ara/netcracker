const {performance} = require('perf_hooks');

let arr = [1,2,3,4,5,6,7,8];
let targetElem = 8;

/**
 * Performs a standard linear search for an element in an array
 * @param {Array}} source array
 * @param {Number} original number
 * @returns - returns the index of an element in an array.
 * If it is not there, it returns - 1
 */
function liniearSearch(array, digit){
    let resultIndex = -1;
    for(let index = 0; index < array.length; ++index){
        if(array[index] === digit){
            resultIndex = index;
        }
    }
    return resultIndex;
}

/**
 * Performs a standard binary search for an element in an array
 * @param {Array} source array
 * @param {Number} original number
 * @returns - returns the index of an element in an array.
 * If it is not there, it returns - 1
 */
function binarySearch(array, digit){
    let startIndex = 0;
    let endIndex = array.length - 1;
    while (startIndex <= endIndex) {
        let middleIndex = Math.floor((startIndex + endIndex) / 2);
        if (array[middleIndex] === digit) {
            return middleIndex;
        }
        if (digit < array[middleIndex]) {
            endIndex = middleIndex - 1;
        } else {
            startIndex = middleIndex + 1;
        }
    }
    return -1;
}


let starttimeLinear = performance.now();
console.log(`\nResult is:${liniearSearch(arr,targetElem)}`);
starttimeLinear = performance.now() - starttimeLinear;
console.log(`Linear alghoritm's time:${starttimeLinear}`)


let startTimeBinary = performance.now();
console.log(`\nResult is:${binarySearch(arr,targetElem)}`);
startTimeBinary = performance.now() - startTimeBinary;
console.log(`Binary alghoritm's time:${startTimeBinary}\n`)