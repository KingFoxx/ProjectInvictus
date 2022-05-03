`use strict`

import * as DOM from './script.js';

const writeItem = item => {
  const child = document.createElement(`li`);
  child.id = item._id;
  child.innerHTML = `${JSON.stringify(item)}`;
  DOM.listOutput.appendChild(child);
}
const post = () => {
	console.log("Hello");
  axios.post(`http://localhost:8080/create`, {
    name: DOM.inputName.value,
    abbreviation: DOM.inputAbbreviation.value,
    amountCryp: DOM.inputAmountCryp.value,
    cost: DOM.inputCost.value
  })
    .then((response) => {
      if (!Array.isArray(response.data)) {
        writeItem(response.data);
      } else {
        for (let item of response.data) {
          writeItem(item);
        }
      }
    }).catch((err) => {
      console.log(err);
    });
}

DOM.buttonCreate.onclick = () => post();