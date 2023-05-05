import React from "react";
import {useDispatch, useSelector} from "react-redux";

const TodoList = () => {

    const dispatch = useDispatch();

    const listTodo = useSelector(state => {
        return state.todoReducer.data;
    })

    const remove = (id) => {
        dispatch({
            type: "REMOVE",
            id: id,
        })
    }

    return (
        <div>
            <h3>List TODO</h3>
           <div>
               {listTodo && listTodo.length > 0 ? (
                   listTodo.map(todo => (
                       <li key={todo.id}>
                           <span>{todo.todoName}</span>
                           <button type="button" onClick={(e) => remove(todo.id)}>Remove</button>
                       </li>
                   ))
               ) : (
                   <p>No Todo to Dispaly</p>
               )}
               <ul>

               </ul>
           </div>
            <div>
                <h5>Total Todo Task : {listTodo.length}</h5>
            </div>
        </div>
    )
}

export default TodoList