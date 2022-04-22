`use strict`

import * as DOM from '../script.js';

const writeItem = item => {
    const child = document.createElement(`li`);
    child.id = item._id;
    child.innerHTML = `${JSON.stringify(item)}`;
    DOM.listOutput.appendChild(child);
}
const put = (id) => {
    axios.put(`http://localhost:8080/replace/${id}`, {
        id: DOM.inputUpdateId.value,
        name: DOM.inputUpdateName.value,
        abbreviation: DOM.inputUpdateAbbreviation.value,
        amountCryp: DOM.inputUpdateAmountCryp.value,
        cost: DOM.inputUpdateCost.value
    })
        .then((response) => {
            console.log(response);
        }).catch((err) => {
            console.log(err);
        });
}
DOM.buttonUpdate.onclick = () => put(DOM.inputUpdateId.value);