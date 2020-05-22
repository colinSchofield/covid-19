import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'
import Image from 'react-bootstrap/Image'
import BannerImg from '../assets/images/working-on-it.gif'

export default function Admin() {
  return (
    <>
      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard>
            <Image className="img-fluid" src={BannerImg} />
            <MDBCardBody>
              <MDBCardTitle>👷 Under Construction 👷</MDBCardTitle>
              <MDBCardText>
              This application is being built, as we speak..<br/>Please check back later on for more updates!
              </MDBCardText>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
        <MDBCol md='4'>
        </MDBCol>
      </MDBRow>
      <br/>
      <br/>
    </>
  )
}