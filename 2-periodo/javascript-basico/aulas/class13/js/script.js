window.addEventListener("DOMContentLoaded", function () {
    const box = document.getElementById("box");
    const p = document.getElementById("info");

    box.addEventListener("mouseenter", function () {
        p.innerHTML = "Mouse is in the box!";
        p.innerHTML = `${getComputedStyle(box).textAlign} ${getComputedStyle(box).backgroundColor}`;

        // box.classList.remove("mouseOut");
        // box.classList.add("mouseIn");
        box.classList.replace("mouseOut", "mouseIn");
    })

    box.addEventListener("mouseout", function () {
        // box.classList.remove("mouseIn");
        // box.classList.add("mouseOut");
        box.classList.replace("mouseIn", "mouseOut");
    })
})