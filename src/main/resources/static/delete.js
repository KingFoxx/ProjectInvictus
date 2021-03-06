`use strict`

import * as DOM from '../script.js';

const writeItem = item => {
    const child = document.createElement(`li`);
    child.id = item._id;
    child.innerHTML = `${JSON.stringify(item)}`;
    DOM.listOutput.appendChild(child);
}
const deleteId = (id) => {
    axios.delete(`http://localhost:8080/remove/${id}`, { id: DOM.inputDeleteId.value })
        .then((response) => {
            console.log(response);
        }).catch((err) => {
            console.log(err);
        });
}
DOM.buttonDelete.onclick = () => deleteId(DOM.inputDeleteId.value);