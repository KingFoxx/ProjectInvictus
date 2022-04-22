`use strict`

import * as DOM from '../script.js';

const writeItem = item => {
  const child = document.createElement(`li`);
  child.id = item._id;
  child.innerHTML = `<b>ID: ${item.id}</b> <br> Name: ${item.name}<br> Abbreviation: ${item.abbreviation}<br> AmountCryp: ${item.amountCryp} <br> Cost: ${item.cost} <br><br>`;
  DOM.listOutput.appendChild(child);
}
const getName = (name) => {
  DOM.nameOutput.innerHTML = ``;

  axios.get(`http://localhost:8080/getByName/${name}`)
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
DOM.buttonName.onclick = () => getName(DOM.inputFindName.value);