import React from 'react'
import { Navbar, Nav } from 'react-bootstrap'
import TableSearch from './TableSearch'

const NavBar = ({tableData, filterTable}) => {

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
        <TableSearch tableData={tableData} filterTable={filterTable} />
      </Navbar.Collapse>
    </Navbar>
  )
}

export default NavBar