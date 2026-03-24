import React, { useState } from "react";

function TodoApp() {
  const [todos, setTodos] = useState([]);
  const [input, setInput] = useState("");

  // Add Todo
  const addTodo = () => {
    if (input.trim() === "") return;

    const newTodo = {
      id: Date.now(),
      text: input,
      completed: false
    };

    setTodos([...todos, newTodo]);
    setInput("");
  };

  // Delete Todo
  const deleteTodo = (id) => {
    setTodos(todos.filter(todo => todo.id !== id));
  };

  // Toggle Complete
  const toggleTodo = (id) => {
    setTodos(
      todos.map(todo =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo
      )
    );
  };

  return (
    <div style={styles.container}>
      <h2>Todo App</h2>

      <div>
        <input
          type="text"
          value={input}
          placeholder="Enter task..."
          onChange={(e) => setInput(e.target.value)}
          style={styles.input}
        />
        <button onClick={addTodo} style={styles.addBtn}>
          Add
        </button>
      </div>

      <ul style={styles.list}>
        {todos.map(todo => (
          <li key={todo.id} style={styles.listItem}>
            <span
              onClick={() => toggleTodo(todo.id)}
              style={{
                ...styles.text,
                textDecoration: todo.completed ? "line-through" : "none"
              }}
            >
              {todo.text}
            </span>

            <button
              onClick={() => deleteTodo(todo.id)}
              style={styles.deleteBtn}
            >
              X
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

const styles = {
  container: {
    width: "300px",
    margin: "50px auto",
    textAlign: "center",
    fontFamily: "Arial"
  },
  input: {
    padding: "8px",
    width: "70%"
  },
  addBtn: {
    padding: "8px",
    marginLeft: "5px"
  },
  list: {
    listStyle: "none",
    padding: 0
  },
  listItem: {
    display: "flex",
    justifyContent: "space-between",
    marginTop: "10px",
    border: "1px solid #ccc",
    padding: "5px"
  },
  text: {
    cursor: "pointer"
  },
  deleteBtn: {
    background: "red",
    color: "#fff",
    border: "none",
    cursor: "pointer"
  }
};

export default TodoApp;