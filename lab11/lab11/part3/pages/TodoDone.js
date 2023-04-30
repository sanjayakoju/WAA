import React, {useState} from "react";
import ToDoList from "./ToDoList";

export const TodoDone = () => {

    const [todoList, setTodoList] = useState([
        {taskNo: 100, name: 'Add New Feature'},
        {taskNo: 101, name: 'Add New Button'},
        {taskNo: 102, name: 'Add New Component'},
    ]);

    const [doneList, setDoneList] = useState([]);

    const onTodoMove = (taskNo) => {
        let myTask;
        const newList = todoList.filter(task => {
            let isMatch = task.taskNo === taskNo;
            if (isMatch) {
                myTask = task
            }
            return !isMatch
        });
        setTodoList(newList);
        const newDoneList = doneList.concat(myTask);
        setDoneList(newDoneList)
    }

    const onDoneMove = (taskNo) => {
        let foundTask;
        const newList = doneList.filter(task => {
            let isMatch = task.taskNo === taskNo;
            if (isMatch) {
                foundTask = task;
            }
            return !isMatch;
        });
        setDoneList(newList);

        const newTodoList = todoList.concat(foundTask);
        setTodoList(newTodoList);
    }

    return (
        <div className="flex-wrap">
            <div>
                <h1>Todo</h1>
                <ToDoList dataList={todoList} isTodoList={true} handleTaskMoveFunc={onTodoMove} />
            </div>
            <div>
                <h1>Done</h1>
                <ToDoList dataList={doneList} isTodoList={false} handleTaskMoveFunc={onDoneMove} />
            </div>
        </div>
    );
}

export default TodoDone;