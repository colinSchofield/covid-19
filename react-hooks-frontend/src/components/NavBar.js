import React from 'react'
import { Navbar, Nav } from 'react-bootstrap'
import TableSearch from './TableSearch'

const NavBar = () => {

  return (
    <Navbar bg="light" expand="lg" variant="light">
      <Navbar.Brand href="/"><span role="img" aria-labelledby="virus" className="emoji">🦠</span> Covid-19 Daily Statistics <span role="img" aria-labelledby="virus" className="emoji">🦠</span></Navbar.Brand>
      <Navbar.Toggle />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
        <Nav.Link href="/">Home</Nav.Link>

          { /* TODO: Fix SSR under Tomcat/Jetty */ }

          <Nav.Link href="/">About</Nav.Link>
          <Nav.Link href="/">Sign Up</Nav.Link>
          <Nav.Link href="/">Admin</Nav.Link>
        </Nav>
        <TableSearch />
      </Navbar.Collapse>
    </Navbar>
  )
}

export default NavBar