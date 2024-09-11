function add(number:string):number{
  return 0;
}


describe("Should return 0 when input empty", () => {
    it("succeeds", () => {
    expect(add("")).toEqual(0);
  });

});

