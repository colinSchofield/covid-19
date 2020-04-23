import React from 'react'
import './css/App.css'

export default function App() {
    const [ message, setMessage ] = React.useState(null)

    React.useEffect(() => {
        getUserList()
    }, [])

    const getUserList = () => {
      const url = "/api/1.0/list/users"
      const username = "admin"
      const password = "passwd"
      let headers = new Headers();
      headers.append("Authorization", "Basic " + btoa(username + ":" + password));

      fetch(url, { method: "GET", headers: headers })
        .then(response => response.text())
        .then(message => setMessage(message))
    }

  return (
    <div className="App">
      Response: <strong>{message}</strong>
    </div>
  )
}