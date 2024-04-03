function sortSequence(array) {
    let temp, tempArray = [], tempSum = 0, output = [];  
    let slices = [], sums = [];

    // dividindo o array e pegando informações
    for (let i = 0; i < array.length; i++) {
        if(array[i] != 0){
            tempArray.push(array[i]);
        } else {
            tempArray.push(array[i]);
            slices.push(tempArray);
            for (let i = 0; i < tempArray.length; i++) {
                tempSum += tempArray[i];
            }
            sums.push(tempSum);
            tempSum = 0;
            tempArray = [];
        }
    }

    for (let i = 0; i < slices.length; i++) {
        // ordenando cada divisao
        let array = slices[i];
        let len = array.length;
        for (let i = 0; i < len - 1; i++) {
            for (let j = 0; j < len - i - 2; j++) {
                if (array [j] > array [j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    temp = tempSum = 0;

    // ordenando pedaços ordenados de acordo com as somas
    for (let i = 0; i < sums.length; i++) {
        for (let j = 0; j < sums.length - 1; j++) {
            if (sums [j] > sums [j + 1]) {
                tempSum = sums[j + 1];
                sums[j + 1] = sums[j];
                sums[j] = tempSum;

                temp = slices[j + 1];
                slices[j + 1] = slices[j];
                slices[j] = temp;
            }
        }
    }
    
    // juntando pedaços para saida
    for (let i = 0; i < slices.length; i++) {
        let each = slices[i];
        for (let i2 = 0; i2 < each.length; i2++) {
            output.push(each[i2]);
        }
    }
    
    // console.log(output);

    return output;
}

sortSequence([3,2,1,0,5,6,4,0,1,5,3,0,4,2,8,0]);
sortSequence([3,2,1,0,5,6,4,0,1,5,3,0,2,2,2,0]);
sortSequence([2,2,2,0,5,6,4,0,1,5,3,0,3,2,1,0]);