import React from 'react'
import { Navbar, Nav, Button, Form, FormControl } from 'react-bootstrap'

const NavBar = () => {
  return (
    <Navbar bg="light" expand="lg">
      <Navbar.Brand href="/">🦠 Covid-19 Daily Statistics 🦠</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
        <Nav.Link href="/">Home</Nav.Link>

          { /* TODO: Fix SSR under Tomcat/Jetty */ }

          <Nav.Link href="/">About</Nav.Link>
          <Nav.Link href="/">Sign Up</Nav.Link>
          <Nav.Link href="/">Admin</Nav.Link>
        </Nav>
        <Form inline>
          <FormControl type="text" placeholder="Search" className="mr-sm-2" />
          <Button variant="outline-success">Search</Button>
        </Form>
      </Navbar.Collapse>
    </Navbar>
  )
}

export default NavBar