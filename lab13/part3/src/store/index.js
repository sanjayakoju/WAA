import {combineReducers, createStore} from "redux";

const calculatorReducer = (state = {total: 0}, action) => {
    let payload = action.payload;
    let total = state.total
    if(action.type === "+") {
        let add = parseFloat(payload.x) + parseFloat(payload.y)
        return {total: add};
    } else if(action.type === "-") {
        let sum = parseFloat(payload.x) - parseFloat(payload.y)
        return {total: sum};
    } else if(action.type === "*") {
        let mul = parseFloat(payload.x) * parseFloat(payload.y)
        return {total: mul}
    } else if(action.type === "/") {
        let div = parseFloat(payload.x) / parseFloat(payload.y)
        return {total: div}
    }
    return state
}

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
const rootReducer = combineReducers({
    calculatorReducer: calculatorReducer,
    todoReducer: todoReducer
})

export const store = createStore(rootReducer)

export default store;

