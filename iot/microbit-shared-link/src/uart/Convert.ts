export namespace Convert {


    const csvSeparator = ";"
    const lineSeparator = "|"

    /**
     * @param csv must start by header
     */
    export function csvToJs(csv: string): object {
        const ret = {};
        const fields = csv.split(lineSeparator).map(line => line.split(csvSeparator))

        if (fields.length >= 2 && fields.some(arr => arr.length !== fields[0].length)) throw Error("Malformed csv")

        for (const i of fields[0].keys()) {
            ret[fields[0][i]] = ret[fields[1][i]]
            try {
                ret[fields[0][i]] = JSON.parse(fields[1][i])
            } catch (e) {
                // do nothing
            }
        }

        return ret;
    }

    export function jsToCsv(obj: object): string {
        const keys = Object.keys(obj);
        let ret = keys.join(csvSeparator) + lineSeparator;
        ret += keys.map(key => JSON.stringify(obj[key])).join(csvSeparator)
        return ret;
    }


}