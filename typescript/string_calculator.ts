export function add(inputString: string): string {
    if(inputString === ""){
        return "0"
    }
    let res = inputString.split(",").reduce((sum, current) => {
        let number = parseFloat(current);
        return sum + number;
    },0)

    return res.toString();
}


