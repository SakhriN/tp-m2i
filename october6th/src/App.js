import React, { useState, useEffect, useContext, useRef } from 'react';
import TaskForm from './components/Form';
import TaskList from './components/Tasklist';
import TaskContext from './components/TaskContext';

function App() {
  const [tasks, setTasks] = useState([]);
  const [isTaskCompleted, setIsTaskCompleted] = useState(false);

  useEffect(() => {
    // Récupérer les données des tâches depuis le localStorage lors du chargement initial
    const savedTasks = JSON.parse(localStorage.getItem('tasks')) || [];
    setTasks(savedTasks);
  }, []);

  useEffect(() => {
    // Mettre à jour le localStorage à chaque modification des tâches
    localStorage.setItem('tasks', JSON.stringify(tasks));
  }, [tasks]);

  // Fonction pour ajouter une tâche
  function addTask(newTask) {
    setTasks((prevTasks) => [...prevTasks, newTask]);
  }

  // Fonction pour marquer une tâche comme terminée ou non
  function toggleTaskStatus(id) {
    setTasks((prevTasks) =>
      prevTasks.map((task) =>
        task.id === id ? { ...task, completed: !task.completed } : task
      )
    );
  }

  // Fonction pour supprimer une tâche
  function deleteTask(id) {
    setTasks((prevTasks) => prevTasks.filter((task) => task.id !== id));
  }

  return (
    <div>
      <h1>Liste de tâches</h1>
      <TaskContext.Provider value={{ tasks, toggleTaskStatus, deleteTask }}>
        <TaskForm addTask={addTask} />
        <TaskList />
      </TaskContext.Provider>
    </div>
  );
}

export default App;
