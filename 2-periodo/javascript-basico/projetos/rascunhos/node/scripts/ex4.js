// pascal
function pascal(n) {
    if (n === 0 || n === 1) return 1;
    return n * pascal(n - 1);
}

for (let i = 0; i < 10; i++) {
    console.log(pascal(i));
}

