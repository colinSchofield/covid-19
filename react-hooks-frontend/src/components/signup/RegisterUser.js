import React from 'react'
import { MDBIcon, toast, ToastContainer } from 'mdbreact'
import { useHistory } from "react-router-dom"

export default function RegisterUser({signupDetails}) {
  const history = useHistory();

  React.useEffect(() => {

    // TODO Save user to backend

    window.setTimeout(() => toast.success(<span><MDBIcon far icon="check-circle" /> Thanks for registering {signupDetails.name}! </span>), 800)
    history.push("/")
  }, [])

  return (
    <>
    </>
  )
}