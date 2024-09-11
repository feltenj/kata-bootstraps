export function add(inputString: string): string {
    if(inputString === ""){
        return "0"
    }
    let res = inputString.split(",").map(it => {
        let number = parseFloat(it);
        return number
    })

    const resultAsNumber = res.reduce((sum, current) => sum + current, 0);

    return resultAsNumber.toString();
}


