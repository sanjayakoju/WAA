import {createStore} from "redux";


const todoReducer = (state = {data: []}, action) => {
    if(action.type === "ADD") {
        let previousTodo = state.data[state.data.length -1];
        return {data: [...state.data, {id: previousTodo?.id +1 || 1, ...action.todo}]}
    } else if(action.type === "REMOVE") {
        let newData = state.data.filter(todo => todo.id !== action.id);
        return {data: newData}
    }
    return state;
}

export const store = createStore(todoReducer);

export default store;