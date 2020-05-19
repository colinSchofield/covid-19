import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'

export default function Regions({signupDetails}) {
  return (
    <div>
      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard>
            <MDBCardBody>
              <MDBCardTitle>Regions</MDBCardTitle>
              <MDBCardText>
              TODO..
              </MDBCardText>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
        <MDBCol md='4'>
        </MDBCol>
      </MDBRow>
      <br/>
      <br/>
    </div>
  )
}
