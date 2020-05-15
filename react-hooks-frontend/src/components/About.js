import React from 'react'
import { MDBTooltip, MDBBtn, MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol, MDBView } from 'mdbreact'
import Image from 'react-bootstrap/Image'
import MeImg from '../assets/images/me.jpg'
import ReactImg from '../assets/images/react.svg'
import WebPackImg from '../assets/images/web-pack.svg'
import BootStrapImg from '../assets/images/boot-strap.svg'
import FontAwesomeImg from '../assets/images/font-awesome.svg'
import RapidApiImg from '../assets/images/rapid-api.svg'
import AwsImg from '../assets/images/aws.svg'
import JavaImg from '../assets/images/java.svg'
import SpringImg from '../assets/images/spring.svg'
import GitHubImg from '../assets/images/git-hub.svg'
import { FaLinkedin, FaEnvelopeSquare, FaComments } from 'react-icons/fa'

export default function About() {
  return (
    <MDBRow className='align-middle vertical-align'>
      <MDBCol md='4'>
      </MDBCol>
      <MDBCol md='4'>
        <MDBCard wide cascade>
          <MDBCardBody cascade className='text-center'>
            <Image src={MeImg} roundedCircle width={80} />
            <MDBCardTitle className='card-title'>
              <br/>
              <strong>Colin Schofield</strong>
            </MDBCardTitle>
            <p className='font-weight-bold blue-text'>Senior Java Developer</p>
            <MDBCardText>
              Colin is both a backend Java and Full Stack Developer. He has been working in Canada, USA,
              UK &amp; Australia for over fifteen years.
            </MDBCardText>
            <MDBCol>
              <MDBBtn color className="rounded-circle">
                <FaLinkedin onClick={() => {window.open(`https://www.linkedin.com/in/colins`, `_self`)}} color='#0072b1' size={25}/>
              </MDBBtn>
              <MDBBtn color className="rounded-circle">
                <FaEnvelopeSquare onClick={() => {window.open(`mailto:colin_sch@yahoo.com`, `_self`)}} color='#808080'size={25} />
              </MDBBtn>
              <MDBBtn color className="rounded-circle">
                <FaComments onClick={() => {window.open(`sms:+61448644233`, `_self`)}} color='#68bd45' size={25}/>
              </MDBBtn>
            </MDBCol>
            <MDBCardText>
              <br/>
              The following tech stack was used to develop this application:
            </MDBCardText>
            <MDBCol md='12'>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={RapidApiImg} rounded width='12%' /></span>
                <span><strong>Rapid API</strong> CoronaVirus Restful Web Service</span>
              </MDBTooltip>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={AwsImg} rounded width='12%' /></span>
                <span><strong>AWS</strong> Online application hosting</span>
              </MDBTooltip>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={WebPackImg} rounded width='12%' /></span>
                <span><strong>Webpack</strong> JavaScript module bundler</span>
              </MDBTooltip>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={ReactImg} rounded width='12%' /></span>
                <span><strong>React</strong> JavaScript library for building user interfaces</span>
              </MDBTooltip>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={FontAwesomeImg} rounded width='12%' /></span>
                <span><strong>Font Awesoeme</strong> Font and icon toolkit</span>
              </MDBTooltip>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={BootStrapImg} rounded width='12%' /></span>
                <span><strong>Bootstrap</strong> Responsive, mobile-first front-end CSS framework</span>
              </MDBTooltip>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={JavaImg} rounded width='12%' /></span>
                <span><strong>Java</strong> written backend services</span>
              </MDBTooltip>
              <MDBTooltip domElement tag="span" placement="bottom">
                <span><Image src={SpringImg} rounded width='12%' /></span>
                <span><strong>Spring / Spring Boot</strong> Java microservices framework</span>
              </MDBTooltip>
            </MDBCol>
            <MDBCardText>
              <br/>
              View source code here:
              <br/>
              <br/>
              <a href="https://github.com/ColinSchofield/covid-19"><Image className='icon-align-bottom' src={GitHubImg} rounded width={80} /></a>
            </MDBCardText>
          </MDBCardBody>
        </MDBCard>
      </MDBCol>
      <MDBCol md='4'>
      </MDBCol>
    </MDBRow>
  )
}