import {add} from "./string_calculator";

describe("A Test", () => {
  it("fails", () => {
    expect(false as boolean).toEqual(true as boolean);
  });

    it("succeeds", () => {
    expect(true as boolean).toEqual(true as boolean);
  });

  it("emptyString", () => {
    expect(add("")).toEqual("0");
  });

  it("oneNumber", () => {
    expect(add("1")).toEqual("1");
  });

});
