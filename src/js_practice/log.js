console.log("1. script start");

setTimeout(function () {
    console.log("2. setTimeout");
}, 0);

Promise.resolve()
    .then(function () {
        console.log("3. promise1");
    })
    .then(function () {
        console.log("4. promise2");
    });

async function main() {
    console.log("5. async start");
    await Promise.resolve(); // await 会让出线程，后面的代码进入微任务
    console.log("6. async end");
}

main();

console.log("7. script end");
