export function add(number: string): string {
    if(number === ""){
        return "0"
    }
    let res = number.split(",").map(it => {
        let number = parseFloat(it);
        return number
    })
    return "";
}


