import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'
import Image from 'react-bootstrap/Image'
import BannerImg from '../../assets/images/Coronavirus-Banner.jpg'

export default function Confirm({signupDetails}) {
  return (
    <>
      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard>
            <Image className="img-fluid" src={BannerImg} />
            <MDBCardBody>
              <MDBCardTitle>Confirmation</MDBCardTitle>
              <MDBCardText>
              Click <b>Finish</b> to save the following:
              <br/>
              <br/>
              <table>
                <tr>
                  <td className='font-weight-bold blue-text text-left'>Name</td>
                  <td className='text-left'>{signupDetails.name}</td>
                </tr>
                <tr>
                  <td className='font-weight-bold blue-text text-left'>Age</td>
                  <td className='text-left'>{signupDetails.age}</td>
                </tr>
                <tr>
                  <td className='font-weight-bold blue-text text-left'>Gender</td>
                  <td className='text-left'>{signupDetails.gender}</td>
                </tr>
                <tr>
                  <td className='font-weight-bold blue-text text-left'>Notification Email</td>
                  <td className='text-left'>{signupDetails.email}</td>
                </tr>
                <tr>
                  <td className='font-weight-bold blue-text text-left'>Notification SMS</td>
                  <td className='text-left'>{signupDetails.sms}</td>
                </tr>
                <tr>
                  <td className='font-weight-bold blue-text text-left'>Regions</td>
                  <td className='text-left'>{

                    signupDetails.regions}</td>
                </tr>
              </table>
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