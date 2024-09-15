function add(number: string): string {

    if (number === "") {
        return "0";

    } else if (number.includes(",")) {

        let splittedEquation = number.split(",");

        let numberArray = splittedEquation.map(function (number) {
            return Number(number)
        });

        let sum = 0;
        for (let i = 0; i < numberArray.length; i++) {
            sum += numberArray[i]
        }

        return String(sum);

    } else {
        return number;
    }
}


describe("Should return 0 when input empty", () => {
    it("succeeds", () => {
        expect(add("")).toEqual("0");
    });
});


describe("Should return a number when input only one number", () => {
    it("succeeds", () => {
        expect(add("99")).toEqual("99");
    });
});

describe("Comma separated input should add the separated values", () => {
    it("succeeds", () => {
        expect(add("5,90")).toEqual("95");
    });
});

describe("Check add method with unknown number of arguments", () => {
    it("succeeds", () => {
        expect(add("5,90,5,5")).toEqual("105");
    });
});


