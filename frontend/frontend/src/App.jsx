import { useEffect, useState } from 'react'
import './App.css'
import axios from "axios";

function App() {
  const [suggestion, setSuggestion] = useState([])
  const [employee, setEmployee] = useState([])
  const [suggestionType, setSuggestionType] = useState([])
  const [empForm, setEmpForm] = useState({name: "",email:"", password:""})
  const [suggestForm, setSuggestForm] = useState({name: ""})
  const [suggestionForm, setSuggestionForm] = useState({title: "",description:"", status:"", employee_id:"", suggestionType_id:""})
  const handleEmployee = async (e)=>{
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/employee/create", empForm);
      alert("added")
    } catch (error) {
      alert("failed")
      console.log("error",error)
    }
  }
  const handleSugge = async (e)=>{
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/suggest/create", suggestForm);
      alert("added")
    } catch (error) {
      alert("failed")
      console.log("error",error)
    }
  }
  const handleSuggestion = async (e)=>{
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/suggestion/create", suggestionForm);
      alert("added")
    } catch (error) {
      alert("failed")
      console.log("error",error)
    }
  }
  const selectEmp = async ()=>{
    try {
      const response = await axios.get("http://localhost:8080/api/employee/getAll");
      setEmployee(response.data)
    } catch (error) {
      console.log("error",error)
    }
  }
  const selectSugge = async ()=>{
    try {
      const response = await axios.get("http://localhost:8080/api/suggest/getAll");
      setSuggestionType(response.data)
    } catch (error) {
      console.log("error",error)
    }
  }
  const selectSuggestion = async ()=>{
    try {
      const response = await axios.get("http://localhost:8080/api/suggestion/getSuggestion");
      setSuggestion(response.data)
    } catch (error) {
      console.log("error",error)
    }
  }
  useEffect(()=>{
    selectEmp();
    selectSugge();
    selectSuggestion();
  },[])
  return (
    <>
      <div>
        <input type="text" value={empForm.name} onChange={(e)=> setEmpForm({...empForm, name: e.target.value})} placeholder='name'/>
        <input type="text" value={empForm.email} onChange={(e)=> setEmpForm({...empForm, email: e.target.value})} placeholder='email'/>
        <input type="text" value={empForm.password} onChange={(e)=> setEmpForm({...empForm, password: e.target.value})} placeholder='name'/>
        <button onClick={handleEmployee}>Send</button>
      </div>
      <div>
        <input type="text" value={suggestForm.name} onChange={(e)=> setSuggestForm({...suggestForm, name: e.target.value})} placeholder='name'/>
        <button onClick={handleSugge}>Send</button>
      </div>
      <div>
        <input type="text" value={suggestionForm.title} onChange={(e)=> setSuggestionForm({...suggestionForm, title: e.target.value})} placeholder='name'/>
        <input type="text" value={suggestionForm.description} onChange={(e)=> setSuggestionForm({...suggestionForm, description: e.target.value})} placeholder='email'/>
        <input type="text" value={suggestionForm.status} onChange={(e)=> setSuggestionForm({...suggestionForm, status: e.target.value})} placeholder='password'/>
        <select
          value={suggestionForm.employee_id}
          onChange={(e) => setSuggestionForm({...suggestionForm, employee_id: e.target.value})}
        >
          <option value="">Select User</option>
          {employee.map((u) => (
            <option key={u.id} value={u.id}>{u.name}</option>
          ))}
        </select>
        <select
          value={suggestionForm.suggestionType_id}
          onChange={(e) => setSuggestionForm({...suggestionForm, suggestionType_id: e.target.value})}
        >
          <option value="">Select User</option>
          {suggestionType.map((s) => (
            <option key={s.id} value={s.id}>{s.name}</option>
          ))}
        </select>
        <button onClick={handleSuggestion}>Send</button>
      </div>
      <div style={{ marginTop: '40px' }}>
        <h2>Users List</h2>
        {suggestion.map((sugge, index) => (
          <div key={index} >
            <strong>{sugge.id}</strong><strong>{sugge.title}</strong>
            {/* <button style={{ marginLeft: '10px' }} onClick={() => deleteUser(u.id)}>Delete User</button> */}
          </div>
        ))}
      </div>
    </>
  )
}

export default App
