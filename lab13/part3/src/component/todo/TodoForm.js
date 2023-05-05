import React, {useState} from "react";
import {useDispatch} from "react-redux";

const TodoForm = () => {

    const [todoName, setTodoName] = useState("")
    const dispatch = useDispatch()

    const onSubmitTodo = (e) => {
        e.preventDefault()
        dispatch({
            type: "ADD",
            todo: {
                todoName: todoName
            }
        })
    }

    return (
        <div>
            <h3>Add TODO Form</h3>
            <form onSubmit={onSubmitTodo}>
                <div>
                    Todo Task Name :
                    <input
                        type="text"
                        name="todo"
                        value={todoName}
                        onChange={(e) => setTodoName(e.target.value)}
                    />
                </div>
                <div>
                    <button type="submit">Create Todo Task</button>
                </div>
            </form>
        </div>
    )
}

export default TodoForm