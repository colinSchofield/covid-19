import React from 'react'
import './css/App.css'

export default function App() {
    const [ message, setMessage ] = React.useState(null)

    React.useEffect(() => {
        getUserList()
    }, [])

    const getUserList = () => {
        fetch('/api/1.0/list/users')
            .then(response => response.text())
            .then(message => setMessage(message))
    }

  return (
    <div className="App">
      Response: <strong>{message}</strong>
    </div>
  )
}