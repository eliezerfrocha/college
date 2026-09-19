
function mathRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

for (let i = 0; i < 6; i++) {
    console.log(mathRandomInt(1, 10));
}
// console.log(mathRandomInt(1, 10));